package frc.robot;

public final class RobotMap {
    // TODO: Map the motors to the correct port thing

    public static final int DRIVER_JOYSTICK = 0;

    public static final class CAN {
        public static final int TALONFX_DRIVE_BACK_LEFT = 4;
        public static final int TALONFX_DRIVE_FRONT_LEFT = 3;
        public static final int TALONFX_DRIVE_BACK_RIGHT = 2;
        public static final int TALONFX_DRIVE_FRONT_RIGHT = 1;  
    }

    public static final class DIO {
        public static final int DRIVE_LEFT_ENCODER_A = 0;
        public static final int DRIVE_LEFT_ENCODER_B = 1;

        public static final int DRIVE_RIGHT_ENCODER_A = 2;
        public static final int DRIVE_RIGHT_ENCODER_B = 3;
    }

    public static final class JOYSTICK_AXIS {

        // DRIVER
    
        public static final int DRIVE = 1;
        public static final int TURN = 0;
    }
}
