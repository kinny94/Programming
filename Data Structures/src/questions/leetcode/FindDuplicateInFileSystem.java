package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateInFileSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> fileMap = new HashMap<>();
        for (String path: paths) {
            String[] values = path.split(" ");

            for (int i=1; i<values.length; i++) {
                String[] nameContent = values[i].split("\\(");
                String content = nameContent[1].substring(0, nameContent[1].length() - 1);

                String directory = values[0];
                String fileName = nameContent[0];

                String filePath = directory + "/" + fileName;
                fileMap.computeIfAbsent(content, k -> new ArrayList<>()).add(filePath);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> pathsWithSameContent: fileMap.values()) {
            if (pathsWithSameContent.size() > 1) {
                result.add(pathsWithSameContent);
            }
        }
        return result;
    }
}
