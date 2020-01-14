package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;


public class DriveTrain {

    TalonFX leftMotor1;
    TalonFX leftMotor2;
    TalonFX rightMotor1;
    TalonFX rightMotor2;

    XboxController xbox;

    private DifferentialDrive robotDrive ;

    public DriveTrain(){

        if(Constants.isDriveCAN){
            this.initCANMotors();
        }else{

        }

        

    }

    private void initCANMotors() {
        this.leftMotor1 = new TalonFX(0);
        this.leftMotor2 = new TalonFX(1);
        this.rightMotor1 = new TalonFX(2);
        this.rightMotor2 = new TalonFX(3);

        leftMotor1.setNeutralMode(NeutralMode.Brake);
        leftMotor2.setNeutralMode(NeutralMode.Brake);
        rightMotor1.setNeutralMode(NeutralMode.Brake);
        rightMotor2.setNeutralMode(NeutralMode.Brake);


        this.leftMotor2.follow(leftMotor1);
        this.rightMotor2.follow(rightMotor1);
    }

    public void arcadeDrive() {

        double mult = 0.5;
        if(xbox.getAButton()) {
            mult = 1.0;
        }
        if(xbox.getBButton()) {
            mult = 0.25;
        }
        this.leftMotor1.set(ControlMode.PercentOutput, mult*(xbox.getRawAxis(4)+xbox.getRawAxis(1)));
        this.rightMotor1.set(ControlMode.PercentOutput, mult*(xbox.getRawAxis(4)-xbox.getRawAxis(1)));
    }

}