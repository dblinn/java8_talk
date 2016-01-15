package com.vmt;

import java.util.Arrays;

import org.junit.Test;

// Adapted from Java example here: https://en.wikipedia.org/wiki/Command_pattern#Java
public class h_DesignPatternExample {
    /** The Command interface */
    public interface Command {
        void execute();
    }

    public enum State {
        ON("ON"),
        OFF("OFF");

        String state;
        State(String state) {
            this.state = state;
        }

        public State opposite() {
            switch (this) {
                case ON: return OFF;
                default: return ON;
            }
        }
    }

    /** The Receiver class */
    public class Light {
        private State state = State.OFF;

        public Light(State initialState) {
            state = initialState;
        }

        public void setState(State state) {
            this.state = state;
            printState();
        }

        public State getState() { return state; }

        public void printState() {
            System.out.println("The light is " + state.state);
        }
    }

    /** The Command for turning on the light - ConcreteCommand #1 */
    public class FlipUpCommand implements Command {
        private Light theLight;

        public FlipUpCommand(Light light) {
            this.theLight = light;
        }

        @Override    // Command
        public void execute() {
            theLight.setState(State.ON);
        }
    }

    /** The Command for turning off the light - ConcreteCommand #2 */
    public class FlipDownCommand implements Command {
        private Light theLight;

        public FlipDownCommand(Light light) {
            this.theLight = light;
        }

        @Override    // Command
        public void execute() {
            theLight.setState(State.OFF);
        }
    }

    public class ToggleCommand implements Command {
        private Light theLight;

        public ToggleCommand(Light light) {
            this.theLight = light;
        }

        @Override    // Command
        public void execute() {
            theLight.setState(theLight.getState().opposite());
        }
    }

    @Test
    public void testJava7CommandPattern() {
        Light light = new Light(State.OFF);
        Command[] commands = new Command[] {
            new FlipUpCommand(light),
            new FlipDownCommand(light),
            new ToggleCommand(light)
        };

        for (Command command : commands) {
            command.execute();
        }
    }

    @Test
    public void testJava8CommandPattern() {
        Light light = new Light(State.OFF);
        Arrays.<Command>asList(
            // Implement commands as lambdas
        );
    }
}
