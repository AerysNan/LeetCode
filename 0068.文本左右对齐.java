import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */
class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int index = 0;
    while (index < words.length) {
      int tryIndex = index, tryLength = 0, wordLength = 0;
      while (true) {
        if (tryIndex == words.length)
          break;
        tryLength += words[tryIndex].length();
        if (tryLength > maxWidth)
          break;
        tryLength++;
        tryIndex++;
      }
      StringBuilder builder = new StringBuilder();
      if (tryIndex - index == 1) {
        builder.append(words[index]);
        for (int i = 0; i < maxWidth - words[index].length(); i++)
          builder.append(" ");
      } else if (tryIndex == words.length) {
        for (int i = index; i < tryIndex; i++) {
          builder.append(words[i]);
          if (i < tryIndex - 1)
            builder.append(" ");
        }
        int residual = maxWidth - builder.length();
        for (int i = 0; i < residual; i++)
          builder.append(" ");
      } else {
        for (int i = index; i < tryIndex; i++)
          wordLength += words[i].length();
        int totalSpace = maxWidth - wordLength;
        int spaceLength = totalSpace / (tryIndex - index - 1);
        System.out.println(spaceLength);
        int offset = totalSpace % (tryIndex - index - 1);
        for (int i = index; i < tryIndex; i++) {
          builder.append(words[i]);
          if (i < tryIndex - 1) {
            for (int j = 0; j < spaceLength; j++)
              builder.append(" ");
            if (i < index + offset)
              builder.append(" ");
          }
        }
      }
      result.add(builder.toString());
      index = tryIndex;
    }
    return result;
  }
}
