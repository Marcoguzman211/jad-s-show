package com.jad.customer;

import com.jad.show.*;

public class Spectator implements ISpectator, IShowVisitor {
    private final String firstName;
    private final String lastName;

    public Spectator(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void watch(final IShow show) {
        show.accept(this);
    }

    @Override
    public void visit(final Show show) {
        System.out.printf("J'ai assisté au %s %s%n%n", show.getShowType().getName().toLowerCase(), show.getName());
    }

    @Override
    public void visit(final MovieShow show) {
        System.out.printf("J'ai assisté au film %s de %s sorti en %s%n%n",
                show.getName(), show.getDirector(), show.getYearOfRelease());
    }

    @Override
    public void visit(final TheaterShow show) {
        System.out.printf("J'ai assisté à la pièce de théâtre %s de %s.%n", show.getName(), show.getDirector());
        System.out.print("Il y avait : ");
        System.out.print(String.join(", ", show.getActors()));
        System.out.println(",");
        System.out.println();
    }

    @Override
    public void visit(final StreetShow show) {
        System.out.printf("J'ai assisté au spectacle de rue %s.%n", show.getName());
        System.out.print("Il y avait : ");
        System.out.print(String.join(", ", show.getPerformers()));
        System.out.println(",");
        System.out.println();
    }

    @Override
    public void visit(final ConcertShow show) {
        System.out.printf("J'ai assisté au concert %s de %s%n", show.getName(), show.getArtist());
    }
}
