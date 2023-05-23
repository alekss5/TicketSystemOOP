package commands;

import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import javax.xml.bind.JAXBException;

public class Help implements Command{
    @Override
    public void execute(Object[] args) throws NoSuchHallException, NoSuchEventException, JAXBException {
        System.out.print("------------Help------------\n");
        System.out.print("addevent   добавя ново представление\n");
        System.out.print("freeseats  извежда справка за ново представление\n");
        System.out.print("book       запазва билет за представление\n");
        System.out.print("unbook     отменя резервация за представление\n");
        System.out.print("buy        закопува билет за предсавление  \n");
        System.out.print("check      извежда справкa за място по код  \n");
        System.out.print("bookings   извежда справка за запазените представления\n");
        System.out.print("report     извежда справка за закупените билети  \n");
        System.out.print("mostviewed извежда най-гледаните представления  \n");
        System.out.print("Less       извежда представления с под 10% посещаемост\n");
        System.out.print("\n");
        System.out.print("----------File Commands----------\n");
        System.out.print("open       зарежда запазените представления\n");
        System.out.print("close      затваря текущо отворения документ(трябва да бъде изпълнена команда 'open'\n");
        System.out.print("save       записва направените променни\n");
        System.out.print("saveas     записва направените промени като позволява да се промени пътя\n");
        System.out.print("exit       излиза от програмата\n\n");



    }
}
