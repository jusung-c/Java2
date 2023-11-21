package Lab7.adaptee;

import java.util.List;

public interface FileLoader<E> {
    // 파일 가져오기
    List<E> load(String filepath);

    // 파일 내보내기
    void save(String filepath, List<E> list);
}
