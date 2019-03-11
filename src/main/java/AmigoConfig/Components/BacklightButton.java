package AmigoConfig.Components;

import AmigoConfig.AmigoDevice;

import java.util.HashMap;

public class BacklightButton extends Button {

    public enum BacklightStatus {

        ON, OFF, Flashing

    }

    BacklightStatus backlightStatus;

    private HashMap<BacklightStatus,Integer> BacklightMidiData = new HashMap<BacklightStatus,Integer>();



    public BacklightButton(AmigoDevice DeviceConnection, int ControlCode) {
        super(DeviceConnection, ControlCode);

        BacklightMidiData.put(BacklightStatus.ON, 1);
        BacklightMidiData.put(BacklightStatus.OFF, 0);
        BacklightMidiData.put(BacklightStatus.Flashing, 2);

        backlightStatus = BacklightStatus.OFF;


    }

    public void BackLightOn(){
        DeviceConnection.SendDeviceMessage(0x90,ButtonControlCode, BacklightMidiData.get(BacklightStatus.ON));
        backlightStatus = BacklightStatus.ON;
    }

    public void BackLightOff(){
        DeviceConnection.SendDeviceMessage(0x90,ButtonControlCode, BacklightMidiData.get(BacklightStatus.OFF));
        backlightStatus = BacklightStatus.OFF;

    }

    public void BackLightFlash(){
        DeviceConnection.SendDeviceMessage(0x90,ButtonControlCode, BacklightMidiData.get(BacklightStatus.Flashing));
        backlightStatus = BacklightStatus.Flashing;

    }

    public void BackLightToggle(){
        if(backlightStatus.equals(BacklightStatus.ON)){
            BackLightOff();
        }
        else if (backlightStatus.equals(BacklightStatus.OFF)){
            BackLightOn();
        }
    }


}
