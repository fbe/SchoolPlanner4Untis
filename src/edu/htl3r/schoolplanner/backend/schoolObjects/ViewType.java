/* SchoolPlanner4Untis - Android app to manage your Untis timetable
    Copyright (C) 2011  Mathias Kub <mail@makubi.at>
						Gerald Schreiber <mail@gerald-schreiber.at>
						Philip Woelfel <philip@woelfel.at>
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package edu.htl3r.schoolplanner.backend.schoolObjects;

import java.io.Serializable;
/**
 * 
 * Diese abstrakte Klasse ist ein Ansichts-Typ wie z.B. Klasse, Raum, Lehrer oder Fach.
 * Implementierungen, wie oben genannte, enthalten jeweils konkrete Angaben, wie z.B. Klasse: 5AN.
 *
 */
public abstract class ViewType implements Serializable, Comparable<ViewType>, Cloneable {
	
	private static final long serialVersionUID = 4424283163744496080L;
	
	private int id;
	private String name;
	private String longName;
	private String foreColor;
	private String backColor;
	
	/**
	 * Liefert die ID dieses Objekts. Diese wird mit der ID in der gegebenen Datenbank uebereinstimmen.
	 * @return ID des Objekts
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Setzt die ID dieses Objekts. Diese sollte mit der in der gegebenen Datenbank uebereinstimmen.
	 * @param id ID, die benutzt werden soll
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Liefert den Namen dieses Objekts. Wenn dies eine Schulklasse ist, kann dies z.B. 5AN sein.
	 * @return Name des Objekts
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setzt den konkreten Namen des Objekts. Ist dieses Objekt eine Schulklasse, koennte dies z.B. 5AN sein.
	 * @param name Name, der benutzt werden soll
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getForeColor() {
		return foreColor;
	}

	public void setForeColor(String foreColor) {
		this.foreColor = foreColor;
	}

	public String getBackColor() {
		return backColor;
	}

	public void setBackColor(String backColor) {
		this.backColor = backColor;
	}

	@Override
	public String toString() {
		return "ViewType [id=" + id + ", name=" + name + ", longName="
				+ longName + ", foreColor=" + foreColor + ", backColor="
				+ backColor + "]";
	}
	
	@Override
	public int compareTo(ViewType another) {
		return getName().compareTo(another.getName());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
