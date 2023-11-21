package Lab7.adapter;

import Lab7.target.DataCollection;

import java.util.Iterator;
import java.util.List;

// List<E>를 구현한 클래스(Adaptee)를 DataCollection<E> 인터페이스(Target)에 맞추는 역할
public class ListDataCollectionAdapter<E> implements DataCollection<E> { // Target 인터페이스 구현
    // Adaptee
    private List<E> list;

    public ListDataCollectionAdapter(List<E> list) {
        this.list = list;
    }

    // 동일한 동작을 하는 Adaptee의 메서드 연결
    @Override
    public void put(E e) {
        list.add(e);
    }

    @Override
    public void insert(int index, E e) {
        list.add(index, e);
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public E elemAt(int index) {
        return list.get(index);
    }

    @Override
    public int length() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    // Iterator 반환 메서드 오버라이딩
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
