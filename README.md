Prison
========

Prison is a powerful Bukkit plugin that includes tools essential to Prison servers.

Download it at http://dev.bukkit.org/bukkit-plugins/mcprison/

Contributing
========
Feel free to clone the repository and submit pull requests - I need all the help I can get!

API
========
Currently the API is not very extensive, it only adds some support for detailed Rankup and Balance Changed events. However, in the future I will be giving Prison it's own economy system, and a huge API will be implemented for that. For now, if you want to do stuff with Prison in your own plugins, here's the maven stuffs:

```xml
	<repositories>
		<repository>
			<id>prison-repo</id>
			<url>https://github.com/SirFaizdat/Prison/raw/master/releases</url>
		</repository>
	</repositories>

	<dependencies>
		<dependency>
			<groupId>me.sirfaizdat.prison</groupId>
			<artifactId>Prison</artifactId>
			<version>2.0.5.1</version>
		</dependency>
	</dependencies>
