package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {
    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[] {"3"});
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }

    @Test
    void whenMultiValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1", "2", "3", "4"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(1);
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(2);
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected3).isEqualTo(3);
        int selected4 = input.askInt("Enter menu:");
        assertThat(selected4).isEqualTo(4);
    }

    @Test
    void whenNegativeInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(-1);
    }
}