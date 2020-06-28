package com.indproj.kalkulator.ui.zones;

import com.indproj.kalkulator.R;

import java.util.ArrayList;

public class TrainingZones {

    private ArrayList<Zone> zones;

    TrainingZones(int maxHeartRate) {
        zones = new ArrayList<>();
        zones.add(new Zone(
                "Strefa regeneracyjna",
                R.string.desc_reg_zone,
                "niski",
                0.5,
                0.6,
                maxHeartRate
        ));
        zones.add(new Zone(
                "Strefa spalania tłuszczu",
                R.string.desc_far_burning,
                "umiakowany",
                0.6,
                0.7,
                maxHeartRate
        ));
        zones.add(new Zone(
                "Strefa areobowa",
                R.string.desc_aerobic,
                "wysoki",
                0.7,
                0.8,
                maxHeartRate
        ));
        zones.add(new Zone(
                "Strefa anaerobowa",
                R.string.desc_anaerobic,
                "bardzo wysoki",
                0.8,
                0.9,
                maxHeartRate
        ));
        zones.add(new Zone(
                "Strefa czerwona",
                R.string.desc_red,
                "maksymalny",
                0.9,
                1.0,
                maxHeartRate
        ));


    }

    Zone getZone(int pos) {
        return zones.get(pos);
    }

    int size() {
        return zones.size();
    }


    static class Zone {
        String name;
        int description;
        String intensity;
        int [] range;
        private boolean expanded;

        Zone (String name, int description, String intensity, double from, double to, int maxRate) {
            this.name = name;
            this.description = description;
            this.intensity = intensity;
            range = new int[4];
            range[0] = (int) (100*from);
            range[1] = (int) (from * maxRate);
            range[2] = (int) (100*to);
            range[3] = (int) (to *maxRate);
            expanded = false;
        }

        boolean isExpanded() {
            return expanded;
        }

        void setExpanded(boolean expanded) {
            this.expanded = expanded;
        }
    }
}
