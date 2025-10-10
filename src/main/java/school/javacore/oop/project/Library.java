package school.javacore.oop.project;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Publication> publications;

    public Library() {
        this.publications = new ArrayList<>();
    }

    public void addPublication(Publication pub) {
        publications.add(pub);
    }

    public void listPublications() {
        if (!publications.isEmpty()) {
            for (Publication pub : publications) {
                pub.printDetails();
            }
        } else {
            System.out.println("Список пустой");
        }
    }

    public void searchByAuthor(String author) {
        int searchPubSize = 0;
        if (!publications.isEmpty()) {
            for (Publication pub : publications) {
                if (pub.getAuthor().equals(author)) {
                    pub.printDetails();
                    searchPubSize++;
                }
            }

            if (searchPubSize == 0) {
                System.out.println("Не найдено");
            }
        } else {
            System.out.println("Не найдено");
        }
    }
}
