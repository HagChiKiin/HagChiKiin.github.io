package backend.database;

import backend.model.Subject;
import backend.utils.SubjectUtils;

import java.util.ArrayList;

public class SubjectDB {
    public static ArrayList<Subject> subjects = SubjectUtils.getDataFromJsonFile("subject.json");
}
