package ru.lnti.elterionrpg.rpginventory.network;

import ru.lnti.elterionrpg.elterionrpg;
import ru.lnti.elterionrpg.rpginventory.network.OpenInventoryMessage.Handler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
	public static SimpleNetworkWrapper network;

    public static void init() {

        //�������������� �����, ��� ���������� ��������� � ���������� ������� ����� �������� � ��������. TestMod.MOD_ID - ���� ����.
        network = NetworkRegistry.INSTANCE.newSimpleChannel(elterionrpg.MOD_ID);
        /*    ������������ �����. ���������: ����� �����������(����������� �����, ������� ����� ������ OpenInventoryMessage),
              ����� ������ ���������, �������������, �������, �� ������� ����� �������������� �����.
              ��� ��� �� �������� ��� �� ������, ��� �������� GUI ����� ������, �� ��������� Side.SERVER
        */
        network.registerMessage(OpenInventoryMessage.Handler.class, OpenInventoryMessage.class, 0, Side.SERVER);
    }
}

