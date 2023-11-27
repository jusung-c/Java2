package hw8.finderTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFinder<T> {
    // 조회한 원소 리스트 저장할 변수
    private final List<T> foundList = new ArrayList<>();

    // 템플릿 메서드 -> 알고리즘 뼈대로 final로 변하지 않도록 선언
    public final List<T> find(List<T> elements){
        // 사용자 입력을 받은 후 저장
        Object input = getUserInput();

        // 주어진 리스트를 돌면서 체크
        for (T e : elements) {
            // 사용자에게 입력받은 조건과 순환하고 있는 원소를 비교
            if (predicate(e, input)) {
                // 맞다면 리스트에 추가
                foundList.add(e);
            }
        }

        // 일치하는 리스트 반환
        return foundList;
    }

    // Finder 마다 입력받는 타입이 다르므로 제네릭으로 설정
    protected abstract <R> R getUserInput();
    protected abstract boolean predicate(T e, Object input);

}
