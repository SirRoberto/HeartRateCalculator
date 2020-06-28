package com.indproj.kalkulator;

import java.util.ArrayList;

class InfoContainer {

    private ArrayList<Info> list;

    InfoContainer() {
        list = new ArrayList<>();
        list.add(new Info(
                R.string.title_info_benefits,
                R.string.body_info_benefits
        ));

        list.add(new Info(
                R.string.title_info_heartRate,
                R.string.body_info_heartRate
        ));

        list.add(new Info(
                R.string.title_info_arterialPulse,
                R.string.body_info_arterialPulse
        ));

        list.add(new Info(
                R.string.title_info_venousPulse,
                R.string.body_info_venousPulse
        ));

        list.add(new Info(
                R.string.title_info_restingHeartRate,
                R.string.body_info_restingHeartRate
        ));

        list.add(new Info(
                R.string.title_info_testMaxHeartRate,
                R.string.body_info_testMaxHeartRate
        ));

        list.add(new Info(
                R.string.title_info_optimalPulse,
                R.string.body_info_optimalPulse
        ));
    }

    Info getInfo(int idx) {
        return list.get(idx);
    }

    int size() {
        return list.size();
    }


    static class Info {
        int title;
        int bodyText;
        private boolean isExpanded;

        Info(int title, int bodyText) {
            this.title = title;
            this.bodyText = bodyText;
        }

        boolean isExpanded() {
            return isExpanded;
        }

        void setExpanded(boolean expanded) {
            isExpanded = expanded;
        }
    }
}
