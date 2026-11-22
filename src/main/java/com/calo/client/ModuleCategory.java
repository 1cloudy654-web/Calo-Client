package com.calo.client;

public enum ModuleCategory {
    VISUALS("Visuals"),
    AC_OFF("AC OFF"),
    BASE_FINDING("Base Finding"),
    COMBAT("Combat"),
    DONUT("Donut"),
    CLIENT("Client"),
    CONFIG("Config");

    public final String title;
    ModuleCategory(String title) { this.title = title; }
}
