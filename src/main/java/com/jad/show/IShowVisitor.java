package com.jad.show;

public interface IShowVisitor {
    void visit(Show show);
    void visit(MovieShow show);
    void visit(TheaterShow show);
    void visit(StreetShow show);
    void visit(ConcertShow show);
}
