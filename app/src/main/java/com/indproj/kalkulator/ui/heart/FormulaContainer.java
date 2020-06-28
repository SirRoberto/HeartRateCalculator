package com.indproj.kalkulator.ui.heart;

import java.util.ArrayList;

class FormulaContainer {
    private ArrayList<Formula> list;

    FormulaContainer() {
        list = new ArrayList<>();
        list.add(new Formula(
                "Formuła Londree i Moeschburger",
                "206.3 - (0.711 * age)",
                "W 1982 r. Londeree i Moeschberger badali sportowców i wyprowadzili " +
                        "kilka równań w celu określenia maksymalnego tętna.",
                "Formułę uważa się za całkiem dokładną") {
            @Override
            public int calculateMaxHeartRate(boolean isMan, int age, int weight) {
                return (int) (206.3 - (0.711 * age));
            }
        });

        list.add(new Formula(
                "Formuła Miller AT al",
                "217 - 0.85 * age",
                "Opracowana przez Miller et al. z Indiana University.",
                null) {
            @Override
            public int calculateMaxHeartRate(boolean isMan, int age, int weight) {
                return (int) (217 - (0.85 * age));
            }
        });

        list.add(new Formula(
                "Formuła Hirofumi Tanaki",
                "208 - 0.7 * age",
                "Formuła opracowana przez trzech lekarzy na podstawie testów i badań " +
                        "500 osób wytrenowanych i nietrenujących w wieku od 18-81 lat.",
                "Błąd w obliczeniach może wynieść ± 10 uderzeń na minutę") {
            @Override
            public int calculateMaxHeartRate(boolean isMan, int age, int weight) {
                return (int) (208 - (0.7 * age));
            }
        });

        list.add(new Formula(
                "Formuła Oakland",
                "206.9 - 0.67 * age",
                "W 2007r. Naukowcy z Oakland University przeanalizowali wartość " +
                        "tętna maksymalnego 132 osobników rejestrowanych rocznie przez 25 lat " +
                        "i opracowali równanie liniowe bardzo podobne do wzoru Tanaki.",
                "Błąd może wynieść ± 5-8 uderzeń na minutę") {
            @Override
            public int calculateMaxHeartRate(boolean isMan, int age, int weight) {
                return (int) (206.9 - (0.67 * age));
            }
        });

        list.add(new Formula(
                "Formuła 9",
                "191.5 - 0.007 * age^2",
                "W 2007r. Naukowcy z Oakland University przeanalizowali wartość " +
                        "tętna maksymalnego 132 osobników rejestrowanych rocznie przez 25 lat " +
                        "i opracowali poniższe równanie nieliniowe",
                "Błąd może wynieść ± 2-5 uderzeń na minutę") {
            @Override
            public int calculateMaxHeartRate(boolean isMan, int age, int weight) {
                return (int) (191.5 - (0.007 * (age * age)));
            }
        });

        list.add(new Formula(
                "Formuła Sally Edwards",
                "Dla mężczyzn:\n" +
                        "210 - age/2 - (0.11 * weight) + 4\n" +
                        "Dla kobiet:\n" +
                        "210 - age/2 - (0.11 * weight)",
                "Zaproponowana przez Sally Edwards - byłą profesjonalna zawodniczkę, " +
                        "biegaczkę, tratlonistkę, autorkę wielu książek na temat treningu w oparciu " +
                        "o monitorowanie intensywności na podstawie tętna.",
                "Błąd w obliczeniach nie przekracza 5%") {
            @Override
            public int calculateMaxHeartRate(boolean isMan, int age, int weight) {
                if (isMan)
                    return (int) (210 - age/2f -(0.11 * weight) + 4);
                else
                    return (int) (210 - age/2f -(0.11 * weight));
            }
        });

        list.add(new Formula(
                "Formuła John Moores University",
                "Dla mężczyzn:\n" +
                        "202 - (0.55 * age)\n" +
                        "Dla kobiet:\n" +
                        "216 - (1.09 * age)",
                "Formuła przeznaczona dla czynnych sportowców w sportach zarówno " +
                        "o charakterze aerobowym, jak i anaerobowym. Opracowany przez Uniwersytet " +
                        "Johna Mooresa z Liverpool.",
                null) {
            @Override
            public int calculateMaxHeartRate(boolean isMan, int age, int weight) {
                if (isMan)
                    return (int) (202 - (0.55 * age));
                else
                    return (int) (216 - (1.09 * age));
            }
        });
    }

    ArrayList<Formula> getList() {
        return list;
    }

}
