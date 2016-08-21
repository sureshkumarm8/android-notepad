package ir.cafebazaar.notepad.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import ir.cafebazaar.notepad.database.AppDatabase;
import java.util.Date;

/**
 * Created by MohMah on 8/17/2016.
 */
@ModelContainer
@Table(database = AppDatabase.class, allFields = true)
public class Folder extends BaseModel implements Parcelable{

	@PrimaryKey(autoincrement = true)
	private int id;
	private String name;
	private Date createdAt;

	public Folder(){
	}

	protected Folder(Parcel in){
		id = in.readInt();
		name = in.readString();
	}

	public static final Creator<Folder> CREATOR = new Creator<Folder>(){
		@Override
		public Folder createFromParcel(Parcel in){
			return new Folder(in);
		}

		@Override
		public Folder[] newArray(int size){
			return new Folder[size];
		}
	};

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Date getCreatedAt(){
		return createdAt;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	@Override public int describeContents(){
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags){

		dest.writeInt(id);
		dest.writeString(name);
	}
}
