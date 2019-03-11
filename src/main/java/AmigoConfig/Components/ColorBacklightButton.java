package AmigoConfig.Components;

import AmigoConfig.AmigoDevice;

import java.util.HashMap;

public class ColorBacklightButton extends BacklightButton {

    public enum BacklightColors{

        GREEN, RED, YELLOW, OFF

    }

    private BacklightColors backLightColorStatus;

    private HashMap<BacklightColors,Integer> BacklightColorMIDIData = new HashMap<BacklightColors,Integer>();

    private HashMap<BacklightColors,Integer> BacklightFlashingColorMIDIData = new HashMap<BacklightColors,Integer>();


    public ColorBacklightButton(AmigoDevice DeviceConnection, int ControlCode) {
        super(DeviceConnection, ControlCode);


        BacklightColorMIDIData.put(BacklightColors.GREEN, 1);
        BacklightColorMIDIData.put(BacklightColors.RED, 3);
        BacklightColorMIDIData.put(BacklightColors.YELLOW, 5);
        BacklightColorMIDIData.put(BacklightColors.OFF, 0);


        BacklightFlashingColorMIDIData.put(BacklightColors.GREEN, 2);
        BacklightFlashingColorMIDIData.put(BacklightColors.RED, 4);
        BacklightFlashingColorMIDIData.put(BacklightColors.YELLOW, 6);

        backLightColorStatus = BacklightColors.GREEN;


    }

    @Override
    public void BackLightOn() {
       DeviceConnection.SendDeviceMessage(0x90,
                                            ButtonControlCode,
                                            BacklightColorMIDIData.get(backLightColorStatus));


       backlightStatus = BacklightStatus.ON;
    }


    @Override
    public void BackLightOff() {

        DeviceConnection.SendDeviceMessage(0x90,
                ButtonControlCode,
                BacklightColorMIDIData.get(BacklightColors.OFF));

        backlightStatus = BacklightStatus.OFF;
    }

    @Override
    public void BackLightFlash() {
        DeviceConnection.SendDeviceMessage(0x90,
                ButtonControlCode,
                BacklightFlashingColorMIDIData.get(backLightColorStatus));

        backlightStatus = BacklightStatus.Flashing;
    }

    @Override
    public void BackLightToggle() {
        if(backlightStatus.equals(BacklightStatus.ON)){
            this.BackLightOff();
        }
        else if (backlightStatus.equals(BacklightStatus.OFF)){
            this.BackLightOn();
        }
    }

    private void updateColor(){
        if(backlightStatus.equals(BacklightStatus.ON)){
            BackLightOn();
        }

    }

    public void Green(){
        this.backLightColorStatus = BacklightColors.GREEN;
        updateColor();
    }

    public void Red(){
        this.backLightColorStatus = BacklightColors.RED;
        updateColor();
    }

    public void Yellow(){
        this.backLightColorStatus = BacklightColors.YELLOW;
        updateColor();
    }


}
