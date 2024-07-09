// import React, { useState } from 'react';

// import { styled } from '@mui/material/styles';
// import Card from '@mui/material/Card';
// import CardHeader from '@mui/material/CardHeader';
// import CardMedia from '@mui/material/CardMedia';
// import CardContent from '@mui/material/CardContent';
// import CardActions from '@mui/material/CardActions';
// import Collapse from '@mui/material/Collapse';
// import Avatar from '@mui/material/Avatar';
// import IconButton from '@mui/material/IconButton';
// import Typography from '@mui/material/Typography';
// import { red } from '@mui/material/colors';
// import FavoriteIcon from '@mui/icons-material/Favorite';
// import ShareIcon from '@mui/icons-material/Share';
// import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
// import MoreVertIcon from '@mui/icons-material/MoreVert';

// import food_img from '../food/1.jpg';

// const FourApp = () => {
//     const handleExpandClick=()=>{
//         setExpanded(!expanded);
//     }

//     const [expanded, setExpanded] = React.useState(false);
//   const [heartcolor, setHeartColor] = useState(false);


//     return (
//         <div>
//             <h3 className='alert alert-danger'>FourApp-mui의 card</h3>

//             <Card sx={{ maxWidth: 345 }}>
//       <CardHeader
//         avatar={
//           <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
//             R
//           </Avatar>
//         }
//         action={
//           <IconButton aria-label="settings">
//             <MoreVertIcon />
//           </IconButton>
//         }
//         title="Sandwich"
//         subheader="07-09-2024"
//       />
//       <CardMedia
//         component="img"
//         height="200px"
//         image={food_img}
//         alt="food"
//       />
//       <CardContent>
//         <Typography variant="body2" color="text.secondary">
//           000
//         </Typography>
//       </CardContent>
//       <CardActions disableSpacing>
//         <IconButton aria-label="add to favorites" style={{color:heartcolor?'red':'gray'}} onClick={()=>setHeartColor(!heartcolor)}>
//           <FavoriteIcon />
//         </IconButton>
//         <IconButton aria-label="share">
//           <ShareIcon />
//         </IconButton>
//         <ExpandMore
//           expand={expanded}
//           onClick={handleExpandClick}
//           aria-expanded={expanded}
//           aria-label="show more"
//         >
//           <ExpandMoreIcon />
//         </ExpandMore>
//       </CardActions>
//       <Collapse in={expanded} timeout="auto" unmountOnExit>
//         <CardContent>
//           <Typography paragraph>Method:</Typography>
//           <Typography paragraph>
//             111
//           </Typography>
//           <Typography paragraph>
//             222
//           </Typography>
//           <Typography paragraph>
//             333
//           </Typography>
//           <Typography>
//             444
//           </Typography>
//         </CardContent>
//       </Collapse>
//     </Card>

//         </div>
//     );
// };

// // ==============================================================================

// const ExpandMore = styled((props) => {
//   const { expand, ...other } = props;
//   return <IconButton {...other} />;
// })(({ theme, expand }) => ({
//   transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
//   marginLeft: 'auto',
//   transition: theme.transitions.create('transform', {
//     duration: theme.transitions.duration.shortest,
//   }),
// }));

// // ================================================================================

// export default FourApp;



import React, { useState } from 'react';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';

import bingsoo from '../food/11.jpg';

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
}));

const FourApp = () => {
    const [expanded, setExpanded] = React.useState(false);
    const [heartcolor,setHeartColor]=useState(false);

    const handleExpandClick = () => {
      setExpanded(!expanded);
    };

    return (
        <div>
            <h3 className='alert alert-danger'>FourApp-mui 의 Card</h3>

            <Card sx={{ maxWidth: 345 }}>
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            R
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        title="여름 특선 망고 빙수"
        subheader="7 09, 2024"
      />
      <CardMedia
        component="img"
        height="194"
        image={bingsoo}
        alt="Paella dish"
      />
      <CardContent>
        <Typography variant="body2" color="text.secondary">
          태국산 신선한 망고가 한가득 들어있어요
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="add to favorites" 
        style={{color:heartcolor?'red':'gray'}}
        onClick={()=>setHeartColor(!heartcolor)}>
          <FavoriteIcon />
        </IconButton>
        <IconButton aria-label="share">
          <ShareIcon />
        </IconButton>
        <ExpandMore
          expand={expanded}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </ExpandMore>
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
          <Typography paragraph>Method:</Typography>
          <Typography paragraph>
            다른 빙수로는 자몽 빙수, 팥빙수도 있어요
          </Typography>
          <Typography paragraph>
            각종 맛있는 빵과 음료도 준비되어있어요
          </Typography>
          <Typography paragraph>
            브런치로는 어쩌곻 저쩌고 ..등등이 있어요
          </Typography>          
        </CardContent>
      </Collapse>
    </Card>
        </div>
    );
};

export default FourApp;