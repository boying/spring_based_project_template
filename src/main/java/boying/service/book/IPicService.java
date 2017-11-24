package boying.service.book;

import boying.domain.book.Pic;

/**
 * Created by boying on 17-11-23.
 */
public interface IPicService {
    void addPicThrowException(Pic pic);

    void addPicSelfInvocation(Pic pic);

    Pic getPic(long id);
}
