import java.util.*;
import java.util.stream.Collectors;

public class ReportGenerator {
    private final Collection<? extends Document> documents;

    public ReportGenerator(Collection<? extends Document> documents) {
        if (documents == null || documents.isEmpty()) {
            throw new IllegalArgumentException("Documents collection must be non‑empty");
        }
        this.documents = documents;
    }

    public Map<String, Integer> countByType() {
        Map<String, Integer> map = new HashMap<>();
        for (Document d : documents) {
            String key = d.getClass().getSimpleName();
            map.merge(key, 1, Integer::sum);
        }
        return map;
    }

    public Map<String, Double> averageTextLengthByType() {
        Map<String, IntSummaryStatistics> agg = new HashMap<>();
        for (Document d : documents) {
            String key = d.getClass().getSimpleName();
            agg.computeIfAbsent(key, k -> new IntSummaryStatistics()).accept(d.getText().length());
        }
        Map<String, Double> res = new HashMap<>();
        for (Map.Entry<String, IntSummaryStatistics> e : agg.entrySet()) {
            double avg = e.getValue().getAverage();
            res.put(e.getKey(), formatDouble(avg));
        }
        return res;
    }

    public String exportToJson() {
        Map<String, Integer> counts = countByType();
        Map<String, Double> avgs = averageTextLengthByType();
        List<String> keys = counts.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (int i = 0; i < keys.size(); i++) {
            String k = keys.get(i);
            sb.append(" \"").append(k).append("\": {")
              .append("\"count\": ").append(counts.getOrDefault(k, 0)).append(", ")
              .append("\"avgLength\": ").append(avgs.getOrDefault(k, 0.0))
              .append("}");
            if (i < keys.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public String exportToCsv() {
        Map<String, Integer> counts = countByType();
        Map<String, Double> avgs = averageTextLengthByType();
        List<String> keys = counts.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append("Type,Count,AverageLength\n");
        for (String k : keys) {
            sb.append(k).append(',')
              .append(counts.getOrDefault(k, 0)).append(',')
              .append(avgs.getOrDefault(k, 0.0)).append('\n');
        }
        return sb.toString();
    }

    public boolean isEmpty() { return documents == null || documents.isEmpty(); }

    public static double formatDouble(double value) {
        return Math.round(value * 10.0) / 10.0;
    }
}
