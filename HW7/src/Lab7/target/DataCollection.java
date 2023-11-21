package Lab7.target;

// Iterable<E>를 확장하며 요소의 컬렉션을 나타내는 커스텀 컬렉션
public interface DataCollection<E> extends Iterable<E> {
    // 요소 추가
    void put(E e);

    // 인덱스에 요소 삽입
    void insert(int index, E e);

    // 주어진 인덱스의 요소 삭제
    void remove(int index);

    // 주어진 인덱스의 요소 반환
    E elemAt(int index);

    // 요소의 개수 반환
    int length();

    // 모든 요소 제거 후 초기화
    void clear();
}
