package hashmap;

import java.util.*;
import java.util.function.BiFunction;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                count++;
            }
        }
        return totalScore / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            list.add(new Label(pupil.name(), (double) totalScore / pupil.subjects().size()));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        BiFunction<Integer, Integer, Integer> function = Integer::sum;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), function);
            }
        }
        List<Label> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            list.add(new Label(pupil.name(), totalScore));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Label(entry.getKey(), entry.getValue()));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}
