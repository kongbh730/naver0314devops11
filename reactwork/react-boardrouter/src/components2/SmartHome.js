import React, { useCallback, useState } from 'react';
import Light from './Light';

const SmartHome = () => {

    const [masterOn, setMasterOn] = useState(false);
    const [kitchenOn, setKitchenOn] = useState(false);
    const [bathOn, setBathOn] = useState(false);

    // const toggleMaster=()=>{
    //     setMasterOn(!masterOn);
    // }
    
    // const toggleKitchen=()=>{
    //     setKitchenOn(!kitchenOn);
    // }

    // const toggleBath=()=>{
    //     setBathOn(!bathOn);
    // }

    const toggleMaster = useCallback(()=>{
        setMasterOn(!masterOn);
    },[masterOn])

    const toggleKitchen = useCallback(()=>{
        setKitchenOn(!kitchenOn);
    },[kitchenOn])

    const toggleBath = useCallback(()=>{
        setBathOn(!bathOn);
    },[bathOn])

    return (
        <div style={{margin:'100px 100px'}}>
            <Light room={'침실'} on={masterOn} toggle={toggleMaster}></Light>
            <Light room={'주방'} on={kitchenOn} toggle={toggleKitchen}></Light>
            <Light room={'욕실'} on={bathOn} toggle={toggleBath}></Light>
        </div>
    );
};

export default SmartHome;