package com.offbeet.deterministic;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import com.offbeet.deterministic.FleetingDataAndServices.Factory;
import com.offbeet.deterministic.songs.DoADear;
import com.offbeet.deterministic.songs.DoMiMi;
import com.offbeet.deterministic.songs.SolDoLaFa;

public class CharacterizeSingingPets {

	private static final LinkedList<Command> EMPTY = new LinkedList<Command>();

	@Test
	public void characterize() {
		Tempo tempo = new Tempo(200);
		SingingAnimal[] choire = { new Dog("Fluffy", new DoMiMi()), new Cat("Max", new SolDoLaFa())};

		Command Pat_Dog_Fluffy = new Pat(choire[0]);
		
		
		ManualClock clock = new ManualClock(ZoneId.systemDefault());
		ManualSeedGenerator generator = new ManualSeedGenerator();
		Factory fleetingfactory = new FleetingDataAndServices.Factory(clock, generator);
		Conductor c = new Conductor(fleetingfactory, choire, tempo);
		
		Helper h = new Helper(c, tempo, clock, generator, fleetingfactory);
				
		{
			h.emulateDataAndServices(1432080620001L, 7563871720270037707L, new Command[]{});
			h.assertSang(new String[]{"woof 0","meow 4"});

			h.emulateDataAndServices(1432080620301L, 6004105365455741043L, new Command[]{});
			h.assertSang(new String[]{"woof 2"});

			h.emulateDataAndServices(1432080620600L, 9022081048711108442L, new Command[]{});
			h.assertSang(new String[]{"woof 2","meow 0"});

			h.emulateDataAndServices(1432080621200L, 4108521295915813138L, new Command[]{});
			h.assertSang(new String[]{"woof 2","meow 5"});

			h.emulateDataAndServices(1432080621500L, -1953510376471883360L, new Command[]{});
			h.assertSang(new String[]{"woof 4"});

			h.emulateDataAndServices(1432080621800L, -3327666329122253653L, new Command[]{});
			h.assertSang(new String[]{"woof 4","meow 3"});

			h.emulateDataAndServices(1432080622400L, 8747148489803687441L, new Command[]{});
			h.assertSang(new String[]{"woof 1","meow 2"});

			h.emulateDataAndServices(1432080622700L, 4939126498966081607L, new Command[]{});
			h.assertSang(new String[]{"woof 3"});

			h.emulateDataAndServices(1432080623000L, -8088786479030807538L, new Command[]{});
			h.assertSang(new String[]{"woof 3","meow 0"});

			h.emulateDataAndServices(1432080623600L, -3489758736937311311L, new Command[]{});
			h.assertSang(new String[]{"woof 5","meow 1"});

			h.emulateDataAndServices(1432080623900L, -1738962333615642509L, new Command[]{});
			h.assertSang(new String[]{"woof 6"});

			h.emulateDataAndServices(1432080624200L, 2283590070665164985L, new Command[]{});
			h.assertSang(new String[]{"woof 6"});

			h.emulateDataAndServices(1432080624810L, -6482726126223478014L, new Command[]{});
			h.assertSang(new String[]{"woof 0","meow 4"});

			h.emulateDataAndServices(1432080625138L, 2662704980733421504L, new Command[]{});
			h.assertSang(new String[]{"woof 2"});

			h.emulateDataAndServices(1432080625438L, -8256639604001284747L, new Command[]{});
			h.assertSang(new String[]{"woof 2","meow 0"});

			h.emulateDataAndServices(1432080626038L, -2489578272066435966L, new Command[]{});
			h.assertSang(new String[]{"woof 2","meow 5"});

			h.emulateDataAndServices(1432080626353L, -5729231163633027289L, new Command[]{});
			h.assertSang(new String[]{"woof 4"});

			h.emulateDataAndServices(1432080626638L, 1673849496749816299L, new Command[]{});
			h.assertSang(new String[]{"meow 6"});

			h.emulateDataAndServices(1432080626695L, -1445046291667594634L, new Command[]{});
			h.assertSang(new String[]{"woof 4"});

			h.emulateDataAndServices(1432080627238L, 3659538354302547482L, new Command[]{});
			h.assertSang(new String[]{"meow 7"});

			h.emulateDataAndServices(1432080627314L, -8601450823690971435L, new Command[]{});
			h.assertSang(new String[]{"woof 1"});

			h.emulateDataAndServices(1432080627613L, 1444978789615982329L, new Command[]{});
			h.assertSang(new String[]{"woof 3"});

			h.emulateDataAndServices(1432080627838L, 1790135229835494589L, new Command[]{});
			h.assertSang(new String[]{"meow 8"});

			h.emulateDataAndServices(1432080627917L, -6525195350316712196L, new Command[]{});
			h.assertSang(new String[]{"woof 3"});

			h.emulateDataAndServices(1432080628438L, 8811926367272192693L, new Command[]{});
			h.assertSang(new String[]{"meow 7"});

			h.emulateDataAndServices(1432080628513L, 8831792875303761426L, new Command[]{});
			h.assertSang(new String[]{"woof 5"});

			h.emulateDataAndServices(1432080628813L, 5827407647620189813L, new Command[]{});
			h.assertSang(new String[]{"woof 6"});

			h.emulateDataAndServices(1432080629113L, -6390179080307842658L, new Command[]{});
			h.assertSang(new String[]{"woof 6"});

			h.emulateDataAndServices(1432080629647L, -4955531093288304165L, new Command[]{});
			h.assertSang(new String[]{"meow 4"});

			h.emulateDataAndServices(1432080629724L, 4590854956661462871L, new Command[]{});
			h.assertSang(new String[]{"woof 0"});

			h.emulateDataAndServices(1432080630036L, 6446044142553586576L, new Command[]{});
			h.assertSang(new String[]{"woof 2"});

			h.emulateDataAndServices(1432080630245L, -3790280191832149098L, new Command[]{});
			h.assertSang(new String[]{"meow 0"});

			h.emulateDataAndServices(1432080630355L, 3607536204575071129L, new Command[]{});
			h.assertSang(new String[]{"woof 2"});

			h.emulateDataAndServices(1432080630846L, -6964524695591645792L, new Command[]{});
			h.assertSang(new String[]{"meow 5"});

			h.emulateDataAndServices(1432080630959L, 8639890016368772680L, new Command[]{});
			h.assertSang(new String[]{"woof 2"});

			h.emulateDataAndServices(1432080631261L, -1318023385855888354L, new Command[]{});
			h.assertSang(new String[]{"woof 4"});

			h.emulateDataAndServices(1432080631475L, -3308366105459263302L, new Command[]{});
			h.assertSang(new String[]{"meow 3"});

			h.emulateDataAndServices(1432080631588L, 4622190307366164246L, new Command[]{});
			h.assertSang(new String[]{"woof 4"});

			h.emulateDataAndServices(1432080632076L, -3151491583377372021L, new Command[]{});
			h.assertSang(new String[]{"meow 2"});
			
		}
	}
}
