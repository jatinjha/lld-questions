package com.jatin.designpatterns.visitor;

public class VisitorDriver {
    public static void main(String[] args) {
        RoomVisitor roomPricingVisitor = new RoomPricingVisitor();
        RoomVisitor roomMaintenceVisitor = new RoomMaintainceVisitor();

        RoomElement normalRoomElement = new NormalRoom();
        RoomElement deluxRoomElement = new DeluxRoom();

        normalRoomElement.accept(roomPricingVisitor);
        deluxRoomElement.accept(roomPricingVisitor);


        System.out.println("value of normal room - > "+((NormalRoom)normalRoomElement).roomPrice);
        System.out.println("value of delux room - > "+((DeluxRoom)deluxRoomElement).roomPrice);
    }
}
