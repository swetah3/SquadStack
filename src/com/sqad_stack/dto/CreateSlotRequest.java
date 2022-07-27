package com.sqad_stack.dto;

public class CreateSlotRequest {
    private int numberOfSlot;

    public CreateSlotRequest(int numberOfSlot) {
        this.numberOfSlot = numberOfSlot;
    }

    public int getNumberOfSlot() {
        return numberOfSlot;
    }

    public void setNumberOfSlot(int numberOfSlot) {
        this.numberOfSlot = numberOfSlot;
    }
}
