package Assignment07And08;

import java.util.ArrayList;

public class Course {
    public int sectionNumber = 0;
    public String name;
    private ArrayList<Section> sections;

    public Course(String name) {
        this.name = name;
        sections = new ArrayList<>();
    }

    public int getSectionOfStudent(Student student) {
        for (Section section : sections) {
            if (section.isRegistered(student)) {
                return section.getSectionID();
            }
        }
        return -1;
    }

    public boolean isRegistered(Student student) {
        return getSectionOfStudent(student) != -1;
    }

    public Section createNewSection() {
        sections.add(new Section(++sectionNumber));
        return sections.get(sectionNumber - 1);
    }

    public String getCourseName() {
        return this.name;
    }

    public Section getSection(int sectionID) {
        return sections.get(sectionID - 1);
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    @Override
    public String toString() {
        String output = getCourseName() + "\n";

        for (Section section : sections) {
            output = output.concat(section.toString()).concat("\n");
        }

        return output;
    }
}
