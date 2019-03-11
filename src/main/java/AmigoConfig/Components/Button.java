package AmigoConfig.Components;

import AmigoConfig.AmigoDevice;

import javax.naming.ldap.Control;

public class Button extends AmigoComponent {

    public enum ButtonActions {
        OSCCommand, AmigoStateUpdate
    }

    int ButtonControlCode;

    public Button(AmigoDevice DeviceConnection, int ControlCode) {
        super(DeviceConnection);
        this.ButtonControlCode = ControlCode;
    }


    public void NewMidiInput(int StatusCode, int ControlCode, int Velocity) {

    }


}
