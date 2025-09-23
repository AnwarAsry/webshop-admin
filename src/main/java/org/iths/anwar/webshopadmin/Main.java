package org.iths.anwar.webshopadmin;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Book(
                34629,
                "Ready player one",
                "Novel by Ernest Cline, about a dystopian future where people escape reality by living in a vast virtual world called the OASIS.",
                11.99
        );
        Product p2 = new Electronic(
                12938,
                "Apple Macbook Pro 14",
                "A powerful, compact laptop designed for professionals, featuring the M4 chip for enhanced performance and Apple Intelligence features.",
                2099
        );
        Product p3 = new Clothing(
                69302,
                "Round Ultra Mini Bag",
                "Compact size handily holds your smartphone and wallet.",
                13.99
        );
    }
}
