package pl.rental.common.domain;

import java.util.function.Consumer;

public interface Result<T> {

    void result(Consumer<T> success, Consumer<T> invalid, Consumer<T> error);

    static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    class Success<T> implements Result<T> {

        private final T value;

        public Success(T value) {
            this.value = value;
        }


        @Override
        public void result(Consumer<T> success, Consumer<T> invalid, Consumer<T> error) {
            success.accept(value);
        }
    }

    class Invalid<T> implements Result<T> {

        private final T value;

        public Invalid(T value) {
            this.value = value;
        }


        @Override
        public void result(Consumer<T> success, Consumer<T> invalid, Consumer<T> error) {
            invalid.accept(value);
        }
    }

    class Error<T> implements Result<T> {

        private final T value;

        public Error(T value) {
            this.value = value;
        }


        @Override
        public void result(Consumer<T> success, Consumer<T> invalid, Consumer<T> error) {
            error.accept(value);
        }
    }
}
