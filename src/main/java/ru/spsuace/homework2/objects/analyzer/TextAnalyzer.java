package ru.spsuace.homework2.objects.analyzer;


/**
 * Базовый интерефейс фильтра, наследники этого интерефейса должны инкапсулировать в себе всю логику
 * анализа текста.
 * Ниже надо реализовать методы, которые создают фильтры заданного типа (то что они возвращают интерфейс, это как раз
 * прием ООП, где нам не важна конкретная реализация, а важен только контракт, что результат статических методов
 * умеет как-то анализировать текст). Сами статические методы мне нужны для создания тестов,
 * что бы без реальных классов (которые вы напишите) я смог "сэмулировать" их создание.
 *
 * Так же необходимо создать все необходимы методы, которые будут вам нужны для прогона текста
 * по всем фильтрам в классе TextFilterManager
 */
public interface TextAnalyzer {

    static TextAnalyzer createTooLongAnalyzer(long maxLength) {
        return new TooLongTextAnalyzer(maxLength);
    }

    static TextAnalyzer createSpamAnalyzer(String[] spam) {
        return new SpamTextAnalyzer(spam);
    }

    static TextAnalyzer createNegativeTextAnalyzer() {
        return new NegativeTextAnalyzer();
    }

    /**
     * Дополнительное задание: придумать свой фильтр
     */
    static TextAnalyzer createDuplicateAnalyzer(TextToMaxCountPair textToMaxCountPair) {
        return new DuplicateTextAnalyzer(textToMaxCountPair);
    }

    /**
     * Проверка текста
     * @param text текст для проверки
     * @return true - если текст не прошел проверку
     */
    boolean checkText(String text);

    FilterType getFilterType();
}
