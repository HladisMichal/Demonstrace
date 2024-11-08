public class DemonstraceAlgoritmu {
    private String text;
    private String vzorek;
    private enum Kroky { UVOD, VNITRNI_CYKLUS, HLAVNI_PODMINKA, PODMINKA_SPLNENI_UKOLU,
        PODMINKA_KONEC_TEXTU, NESPLNENI_HLAVNI_PODMINKY,KONEC };
    private Kroky aktualniKrok;
    private String popisKroku;
    private int pocetProvedenychKroku;
    private int indexTextu;
    private int indexVzorku;
    private boolean hledej;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVzorek() {
        return vzorek;
    }

    public void setVzorek(String vzorek) {
        this.vzorek = vzorek;
    }

    public Kroky getAktualniKrok() {
        return aktualniKrok;
    }

    public void setAktualniKrok(Kroky aktualniKrok) {
        this.aktualniKrok = aktualniKrok;
    }

    public String getPopisKroku() {
        return popisKroku;
    }

    public void setPopisKroku(String popisKroku) {
        this.popisKroku = popisKroku;
    }

    public int getPocetProvedenychKroku() {
        return pocetProvedenychKroku;
    }

    public void setPocetProvedenychKroku(int pocetProvedenychKroku) {
        this.pocetProvedenychKroku = pocetProvedenychKroku;
    }

    public int getIndexTextu() {
        return indexTextu;
    }

    public void setIndexTextu(int indexTextu) {
        this.indexTextu = indexTextu;
    }

    public int getIndexVzorku() {
        return indexVzorku;
    }

    public void setIndexVzorku(int indexVzorku) {
        this.indexVzorku = indexVzorku;
    }

    public void naZacatek() {
        // Inicializace všech atributů na počáteční hodnoty
        aktualniKrok = Kroky.UVOD;
        pocetProvedenychKroku = 0;
        indexTextu = 0;
        indexVzorku = 0;
        hledej = true;
    }

    public void provedKrok() {
        pocetProvedenychKroku++;
        switch (aktualniKrok) {
            case UVOD:
                // Logika pro úvodní krok
                uvod();
                break;
            case VNITRNI_CYKLUS:
                // Logika pro vnitřní cyklus
                vnitrnicyklus();
                break;
            case HLAVNI_PODMINKA:
                // Hlavní podmínka pro hledání shodných písmenek
                hlavnipodminka();
                break;
            case PODMINKA_SPLNENI_UKOLU:
                // Podmínka pro splnění úkolu
                podminkasplneniukolu();
                break;
            case PODMINKA_KONEC_TEXTU:
                // Podmínka pro zjištění, zda text neskončil
                podminkakonectextu();
                break;
            case NESPLNENI_HLAVNI_PODMINKY:
                // Nesplnění hlavní podmínky
                nesplnenihlavnipodminky();
                break;
            case KONEC:
                konec();
                break;

            }
        }

    private void uvod() {
        System.out.println("Začátek hledání.");
        aktualniKrok = Kroky.VNITRNI_CYKLUS;
    }

    private void vnitrnicyklus() {
        System.out.println("Vnitřní cyklus: Porovnávám znaky.");
        aktualniKrok = Kroky.HLAVNI_PODMINKA;
    }

    private void hlavnipodminka() {
        if (indexTextu < text.length() && indexVzorku < vzorek.length() &&
                text.charAt(indexTextu) == vzorek.charAt(indexVzorku)) {
            System.out.println("Znak "+ getIndexTextu() +" se shoduje.");
            aktualniKrok = Kroky.PODMINKA_SPLNENI_UKOLU;
        } else {
            System.out.println("Znaky "+ getIndexTextu() +" se neshodují.");
            aktualniKrok = Kroky.NESPLNENI_HLAVNI_PODMINKY;
        }
    }

    private void podminkasplneniukolu() {
        if (indexVzorku == vzorek.length() -1) {
            System.out.println("Vzorek nalezen!");
            aktualniKrok = Kroky.KONEC;
        } else {
            indexVzorku += 1;
            indexTextu += 1;
            aktualniKrok = Kroky.HLAVNI_PODMINKA;
        }
    }

    private void podminkakonectextu() {
        if (indexTextu == text.length()) {
            System.out.println("Vzorek nenalezen.");
            aktualniKrok = Kroky.KONEC;
        } else {
            indexTextu += 1;
            indexVzorku = 0;
            aktualniKrok = Kroky.VNITRNI_CYKLUS;
        }
    }

    private void nesplnenihlavnipodminky() {
        indexVzorku = 0;
        aktualniKrok = Kroky.PODMINKA_KONEC_TEXTU;
    }

    private void konec() {
        System.out.println("Hledání dokončeno.");
    }



    public static void main(String[] args) {
        DemonstraceAlgoritmu demonstrace = new DemonstraceAlgoritmu();
        demonstrace.setText("Funguje to doufám");
        demonstrace.setVzorek("to dou");
        demonstrace.naZacatek();

        while (demonstrace.getAktualniKrok() != Kroky.KONEC) {
            demonstrace.provedKrok();
        }
    }


}


