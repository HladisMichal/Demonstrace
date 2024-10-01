public class DemonstraceAlgoritmu {
    private String text;
    private String vzorek;
    private enum Kroky { UVOD, VNITRNI_CYKLUS, HLAVNI_PODMINKA, PODMINKA_SPLNENI_UKOLU,
        PODMINKA_KONEC_TEXTU, NESPLNENI_HLAVNI_PODMINKY, PODMINKA_KONEC_TEXTU2, KONEC };
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
                System.out.println("Začátek hledání.");
                aktualniKrok = Kroky.VNITRNI_CYKLUS;
                break;
            case VNITRNI_CYKLUS:
                // Logika pro vnitřní cyklus
                System.out.println("Vnitřní cyklus: Porovnávám znaky.");
                aktualniKrok = Kroky.HLAVNI_PODMINKA;
                break;
            case HLAVNI_PODMINKA:
                // Hlavní podmínka pro hledání shodných písmenek
                if (indexTextu < text.length() && indexVzorku < vzorek.length() &&
                        text.charAt(indexTextu) == vzorek.charAt(indexVzorku)) {
                    System.out.println("Znaky se shodují.");
                    aktualniKrok = Kroky.PODMINKA_SPLNENI_UKOLU;
                } else {
                    System.out.println("Znaky se neshodují.");
                    aktualniKrok = Kroky.NESPLNENI_HLAVNI_PODMINKY;
                }
                break;
            case PODMINKA_SPLNENI_UKOLU:
                // Podmínka pro splnění úkolu
                if (indexVzorku == vzorek.length() - 1) {
                    System.out.println("Vzorek nalezen!");
                    aktualniKrok = Kroky.KONEC;
                } else {
                    indexVzorku++;
                    aktualniKrok = Kroky.HLAVNI_PODMINKA;
                }
                break;
            case PODMINKA_KONEC_TEXTU:
                // Podmínka pro zjištění, zda text neskončil
                if (indexTextu == text.length()) {
                    System.out.println("Vzorek nenalezen.");
                    aktualniKrok = Kroky.KONEC;
                } else {
                    indexTextu++;
                    indexVzorku = 0;
                    aktualniKrok = Kroky.VNITRNI_CYKLUS;
                }
                break;
            case NESPLNENI_HLAVNI_PODMINKY:
                // Nesplnění hlavní podmínky
                indexTextu++;
                indexVzorku = 0;
                aktualniKrok = Kroky.PODMINKA_KONEC_TEXTU;
                break;
            case KONEC:
                System.out.println("Hledání dokončeno.");
                break;
        }
    }



    public static void main(String[] args) {
        DemonstraceAlgoritmu demonstrace = new DemonstraceAlgoritmu();
        demonstrace.setText("Ahoj světe!");
        demonstrace.setVzorek("svě");
        demonstrace.naZacatek();

        while (demonstrace.getAktualniKrok() != Kroky.KONEC) {
            demonstrace.provedKrok();
        }
    }


}


