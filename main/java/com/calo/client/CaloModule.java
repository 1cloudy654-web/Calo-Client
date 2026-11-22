package com.calo.client;

public final class CaloModule {
    public final String name;
    public final ModuleCategory category;
    public final String description;
    private boolean enabled;

    public CaloModule(String name, ModuleCategory category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }
    public boolean isEnabled() { return enabled; }
    public void toggle() { enabled = !enabled; }
    public void setEnabled(boolean value) { enabled = value; }
}
