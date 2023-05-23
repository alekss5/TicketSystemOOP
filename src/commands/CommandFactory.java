package commands;

import bg.tu_varna.sit.ListOfEvents;

public abstract class CommandFactory {
    static boolean  isOpened = true;
    public static Command getCommand(String name) {
        AddEvent addEvent = new AddEvent();
        if (isOpened) {
            if (name.equalsIgnoreCase("close")) {
                isOpened = false;
                return new Close();

            } else if (name.equalsIgnoreCase("open")) {
                isOpened = true;
                return new OpenXML();
            } else if (name.equalsIgnoreCase("freeseats")) {
                return new FreeSeats();
            }
            else if (name.equalsIgnoreCase("save")) {
                return new SaveXML();
            } else if (name.equalsIgnoreCase("addevent")) {
                return addEvent;
            } else if (name.equalsIgnoreCase("book")) {
                return new BookEvent();
            } else if (name.equalsIgnoreCase("unbook")) {
                return new UnBook();
            } else if (name.equalsIgnoreCase("buy")) {
                return new BuyTicket();
            } else if (name.equalsIgnoreCase("check")) {
                return new CheckCode();
            } else if (name.equalsIgnoreCase("report")) {
                return new Report();
            } else if (name.equalsIgnoreCase("bookings")) {
                return new Bookings();
            } else if (name.equalsIgnoreCase("show")) {
                return new ShowEvents();
            } else if (name.equalsIgnoreCase("mostviewed")) {
                return new MostViewedEvents();
            } else if (name.equalsIgnoreCase("less")) {
                    return new LessThan10P();
            } else if (name.equalsIgnoreCase("help")) {
                return new Help();
            }

            else {
                return null;
            }

        } else {



            if (name.equalsIgnoreCase("open")) {
                isOpened = true;
                return new OpenXML();
            }
            else {
                System.out.print("File is closed! Open file by command 'open'\n");
                return null;
            }
        }
    }
}
