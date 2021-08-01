package trainingTask4.p3;

import java.util.*;

public class TestAnalyze{
    public static void main(String[] args){
        FreqAnalyzer f3 = new FreqAnalyzer("Если я найду такое же предложение то значит копипаст " +
                "Если же не найду то значит немного изменено");
        System.out.println("Частотный анализ слов и символов строки:");
        f3.printWordAnalysis();
        f3.printCharAnalysis();

        FreqAnalyzer f = new FreqAnalyzer("Если я найду такое же предложение то значит копипаст");
        FreqAnalyzer f2 = new FreqAnalyzer("Если же не найду то значит немного изменено");
        System.out.println("Неупорядоченный вывод:");
        f.compareTwo(f2);
        System.out.println("Прямой порядок:");
        f.compareTwo(f2, FreqAnalyzer.Format.regularOrder);
        System.out.println("Обратный порядок:");
        f.compareTwo(f2, FreqAnalyzer.Format.reverseOrder);

    }
}

class FreqAnalyzer {
    private String str;
    private Map<String, Integer> wordDict;
    private Map<Character, Integer> charDict;

    FreqAnalyzer(){}
    FreqAnalyzer(String str){
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private Map<String, Integer> getWordDict() {
        return wordDict;
    }

    private Map<Character, Integer> getCharDict() {
        return charDict;
    }

    /**
     * Возвращает Map<String, Integer>, сопоставляющую каждому
     *   слову (длиной не менее 1 символа) анализируемой строки
     *   количество его вхождений в данную строку.
     * @return Map - результат подсчета количеств вхождений слов
     */
    public Map<String, Integer> wordsAnalyze(){
        if (str == null) {
            throw new NullPointerException();
        }
        wordDict = new HashMap<>();
        String[] words = str.toLowerCase().split(" ");
        for (String word : words) {
            if (!wordDict.containsKey(word)) {
                wordDict.put(word, 1);
            } else {
                wordDict.put(word, wordDict.get(word) + 1);
            }
        }
        return wordDict;
    }

    /**
     * Возвращает Map<Character, Integer>, сопоставляющую каждому
     * символу анализируемой строки количество его вхождений в данную строку.
     * @return Map - результат подсчета количеств вхождений символов
     */
    public Map<Character, Integer> charactersAnalyze(){
        if (str == null) {
            throw new NullPointerException();
        }
        charDict = new HashMap<>();
        char[] characters = str.toLowerCase().toCharArray();
        for (char character : characters) {
            if (!charDict.containsKey(character)) {
                charDict.put(character, 1);
            } else {
                charDict.put(character, charDict.get(character) + 1);
            }
        }
        return charDict;
    }

    /**
     * Выводит частотный анализ по словам
     */
    public void printWordAnalysis() {
        if (wordDict == null){ this.wordsAnalyze(); }
        System.out.println("'Слово' - Количество вхождений:");
        for (String word : wordDict.keySet()) {
            System.out.println("'"+word + "' - " + wordDict.get(word));
        }
        System.out.println();
    }

    /**
     * Выводит частотный анализ по символам
     */
    public void printCharAnalysis() {
        if (charDict == null){ this.charactersAnalyze(); }
        System.out.println("'Символ' - Количество вхождений:");
        for (char character : charDict.keySet()) {
            System.out.println("'"+character + "' - " + charDict.get(character));
        }
        System.out.println();
    }

    enum Format {
        regularOrder,
        reverseOrder,
        cyclicShift
    }

    /**
     * Выводит символьное сравнение двух объектов.
     * Символы выводятся в заданной последовательности (Format), если указан формат.
     * Если формат не указан, символы не упорядочиваются.
     */
    public void compareTwo(FreqAnalyzer other, Format ...format){
        if (format.length>0) {
            Comparator<Character> cmprt;
            switch (format[0]) {
                case regularOrder:
                    cmprt = new Comparator<Character>() {
                        public int compare(Character o1, Character o2) {
                            return o1.toString().compareTo(o2.toString());
                        }
                    };
                    break;
                case reverseOrder:
                    cmprt = new Comparator<Character>() {
                        public int compare(Character o1, Character o2) {
                            return o2.toString().compareTo(o1.toString());
                        }
                    };
                    break;
                default:
                    cmprt = new Comparator<Character>() {
                        public int compare(Character o1, Character o2) {
                            return o1.toString().compareTo(o2.toString());
                        }
                    };
                    break;
            }
            Set<Character> sortedSet = new TreeSet<Character>(cmprt);
            System.out.println("Символы входящие и в первую и во вторую строку одновременно:");
            sortedSet.addAll(this.findSame(other));
            System.out.println(sortedSet);
            System.out.println("Символы входящие в первую, но отсутствующие во второй строке:");
            sortedSet.clear();
            sortedSet.addAll(this.findDiffer(other));
            System.out.println(sortedSet);
            System.out.println("Символы входящие хотя бы в одну из строк:");
            sortedSet.clear();
            sortedSet.addAll(this.findAny(other));
            System.out.println(sortedSet);
            System.out.println();
        }
        else {
            System.out.println("Символы входящие и в первую и во вторую строку одновременно:\n"+this.findSame(other));
            System.out.println("Символы входящие в первую, но отсутствующие во второй строке:\n"+this.findDiffer(other));
            System.out.println("Символы входящие хотя бы в одну из строк:\n"+this.findAny(other));
            System.out.println();
        }
    }

    /**
     * Находит символы, содержащиеся в обеих строках this и other
     * @param other - с чем сравнивается FreqAnalyzer .
     * @return - set символов.
     */
    private Set<Character> findSame(FreqAnalyzer other) {
        if (charDict == null) { this.charactersAnalyze(); }
        if (other.getCharDict() == null) { other.charactersAnalyze(); }
        Set<Character> uniqChar2 = other.getCharDict().keySet();
        Set<Character> uniqChar = this.charDict.keySet();
        Set<Character> result = new HashSet<>(uniqChar);
        result.retainAll(uniqChar2);
        return result;
    }

    /**
     * Находит символы, содержащиеся в this, но отсутствующие в other
     * @param other - с чем сравнивается FreqAnalyzer .
     * @return - set символов.
     */
    private Set<Character> findDiffer(FreqAnalyzer other) {
        if (charDict == null) { this.charactersAnalyze(); }
        if (other.getCharDict() == null) { other.charactersAnalyze(); }
        Set<Character> uniqChar2 = other.getCharDict().keySet();
        Set<Character> uniqChar = this.charDict.keySet();
        Set<Character> result = new HashSet<>();
        for (char character : uniqChar) {
            if (!uniqChar2.contains(character)) {
                result.add(character);
            }
        }
        return result;
    }

    /**
     * Находит символы, содержащиеся хотя бы в одной из строк this и other
     * @param other - с чем сравнивается FreqAnalyzer .
     * @return - set символов.
     */
    private Set<Character> findAny(FreqAnalyzer other) {
        if (charDict == null) { this.charactersAnalyze(); }
        if (other.getCharDict() == null) { other.charactersAnalyze(); }
        Set<Character> uniqChar2 = other.getCharDict().keySet();
        Set<Character> uniqChar = this.charDict.keySet();
        Set<Character> result = new HashSet<>(uniqChar);
        result.addAll(uniqChar2);
        return result;
    }
}
