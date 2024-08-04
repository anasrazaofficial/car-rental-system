package Mapper;


import Model.Owner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnerMapper implements IMapper<Owner> {

    private static final String ID = "id";
    private static final String NAME = "owner_name";
    private static final String CNIC = "owner_cnic";
    private static final String PHONE_NUMBER = "owner_phone_number";
    private static final String COMMISSIONPERCENT = "commissionPercent";
    private static final String TOTALCOMISSION = "totalCommission";
    private static final String ADDRESS = "owner_address";
    private static final String STATUS = "owner_status";

    @Override
    public List<Owner> resultToList(ResultSet resultSet) throws SQLException {
        List<Owner> ownerList = new ArrayList<>();
        while (resultSet.next()) {
            Owner owner = new Owner();
            owner.setId(resultSet.getInt(ID));
            owner.setName(resultSet.getString(NAME));
            owner.setCnic(resultSet.getString(CNIC));
            owner.setPhone_number(resultSet.getString(PHONE_NUMBER));
            owner.setCommissionPercent(resultSet.getInt(COMMISSIONPERCENT));
            owner.setTotalCommission(resultSet.getInt(TOTALCOMISSION));
            owner.setAddress(resultSet.getString(ADDRESS));
            owner.setStatus(resultSet.getBoolean(STATUS));

            ownerList.add(owner);
        }
        return ownerList;
    }

}