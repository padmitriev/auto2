package org.helper.hooks;

public class ClickEvent {

    private long clickTime;
    private int[] coordinates;
    private String buttonType;
    private boolean isDoubleClick;
    public ClickEvent(long clickTime, int[] coordinates, String buttonType, boolean isDoubleClick) {
        this.clickTime = clickTime;
        this.coordinates = coordinates;
        this.buttonType = buttonType;
        this.isDoubleClick = isDoubleClick;
    }
}
