package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;


public class DriveTrain {

    // private VictorSP leftDrive1;
	// private VictorSP rightDrive1;
	// private VictorSP leftDrive2;
    // private VictorSP rightDrive2;

    private VictorSPX leftVictor;
	private VictorSPX rightVictor;
	private TalonSRX leftTalon;
    private TalonSRX rightTalon; 
    
    private DifferentialDrive robotDrive ;

    public DriveTrain(){

        if(Constants.isDriveCAN){
            this.initCANMotors();
            this.robotDrive = new DifferentialDrive(leftTalon, rightTalon);
        }else{

        }

        

    }

    private void initCANMotors(){
        leftVictor = new VictorSPX(Constants.leftVictor);
            leftTalon = new TalonSRX(Constants.leftTalon);
            rightVictor = new VictorSPX(Constants.rightVictor);
            rightTalon = new TalonSRX(Constants.rightTalon);

        leftVictor.follow(leftTalon);
        rightVictor.follow(rightTalon);

        
    }

    


}