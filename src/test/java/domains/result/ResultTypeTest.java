package domains.result;

import domains.card.Card;
import domains.card.Symbol;
import domains.card.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTypeTest {
    @DisplayName("딜러의 결과를 반환하는 메소드 테스트")
    @ParameterizedTest
    @MethodSource("resultTypes")
    void oppose_ResultType_ReturnOpposite(ResultType resultType, ResultType oppositeResultType) {
        assertThat(resultType.oppose()).isEqualTo(oppositeResultType);
    }

    static Stream<Arguments> resultTypes() {
        return Stream.of(
                Arguments.of(ResultType.WIN, ResultType.LOSE),
                Arguments.of(ResultType.DRAW, ResultType.DRAW),
                Arguments.of(ResultType.LOSE, ResultType.WIN)
        );
    }
}
