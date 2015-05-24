package com.offbeet.deterministic;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import com.offbeet.deterministic.FleetingDataAndServices.Factory;
import com.offbeet.deterministic.songs.DoADear;
import com.offbeet.deterministic.songs.DoMiMi;
import com.offbeet.deterministic.songs.SolDoLaFa;

public class CharacterizeRandomCats {

	private static final LinkedList<Command> EMPTY = new LinkedList<Command>();

	@Test
	public void characterize() {
		Tempo tempo = new Tempo(634);
		ISong song = new RandomSong();
		SingingAnimal[] choire = { new Cat("Max", song)};

		Command Pat_Cat_Max = new Pat(choire[0]);
		
		
		ManualClock clock = new ManualClock(ZoneId.systemDefault());
		ManualSeedGenerator generator = new ManualSeedGenerator();
		Factory fleetingfactory = new FleetingDataAndServices.Factory(clock, generator);
		Conductor c = new Conductor(fleetingfactory, choire, tempo);
		
		Helper h = new Helper(c, tempo, clock, generator, fleetingfactory);
				
		{
			h.emulateDataAndServices(1431479920001L, -7875721196514980132L, new Command[]{});
			h.assertSang(new String[]{"meow 6"});

			h.emulateDataAndServices(1431479921183L, 3034579071974745612L, new Command[]{});
			h.assertSang(new String[]{"meow 4"});

			h.emulateDataAndServices(1431479921199L, -8583334352090027327L, new Command[]{});
			h.assertSang(new String[]{"meow 3"});

			h.emulateDataAndServices(1431479921351L, -6875009348633992013L, new Command[]{});
			h.assertSang(new String[]{"meow 0"});

			h.emulateDataAndServices(1431479921716L, 2622473274259310633L, new Command[]{});
			h.assertSang(new String[]{"meow 5"});

			h.emulateDataAndServices(1431479922071L, -1968262312499930995L, new Command[]{});
			h.assertSang(new String[]{"meow 3"});

			h.emulateDataAndServices(1431479922419L, -7131682928640218179L, new Command[]{});
			h.assertSang(new String[]{"meow 4"});

			h.emulateDataAndServices(1431479922745L, -3888069590484755203L, new Command[]{});
			h.assertSang(new String[]{"meow 1"});

			h.emulateDataAndServices(1431479922863L, 7858182027778549785L, new Command[]{});
			h.assertSang(new String[]{"meow 4"});

			h.emulateDataAndServices(1431479923538L, -7541549652259514901L, new Command[]{});
			h.assertSang(new String[]{"meow 1"});

			h.emulateDataAndServices(1431479925454L, -2497493559468906280L, new Command[]{});
			h.assertSang(new String[]{"meow 5"});

			h.emulateDataAndServices(1431479926128L, 4099271502781730343L, new Command[]{});
			h.assertSang(new String[]{"meow 0"});

			h.emulateDataAndServices(1431479926220L, 1313948752881319928L, new Command[]{});
			h.assertSang(new String[]{"meow 3"});

			h.emulateDataAndServices(1431479926554L, -849867419071881814L, new Command[]{});
			h.assertSang(new String[]{"meow 1"});

			h.emulateDataAndServices(1431479926887L, -3170082181883219185L, new Command[]{});
			h.assertSang(new String[]{"meow 6"});

			h.emulateDataAndServices(1431479927844L, -7344363713060551294L, new Command[]{});
			h.assertSang(new String[]{"meow 6"});

			h.emulateDataAndServices(1431479929476L, -5796534855173471095L, new Command[]{});
			h.assertSang(new String[]{"meow 3"});			
		}
	}
}
