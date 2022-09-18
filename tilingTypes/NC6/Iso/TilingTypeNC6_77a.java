package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_77a
   extends TilingType
{
   public TilingTypeNC6_77a(){
      super( "NC6-77a", 6, SymmetryType.p6 );

      paramMin = new int[]{  0,  0,-150};
      paramMax = new int[]{100,120, 150};
      paramDef = new int[]{ 50, 70,  30};
      paramName = new String[]{"Relative Length", "Angle 1", "Angle 2"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,2, 0,0,4, 0},
            {0, 0,2, 1,0,4, 0},

            {0, 3,2, 0,3,4, 0},
            {0, 0,2, 3,0,4, 0},
            {0, 0,2, 4,0,4, 0},
      };
      info = "a=b\nc=f\nA=120\nD=60\nB+F=360\n(C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.7;
      double s60 = Math.sqrt(3)/2;
      double c60 = 0.5;
      
      double ang1 = getParam(paramValues,1);
      double y5 = -ln * getParam(paramValues,0)/100;
      double x5 = -y5 * Math.tan((ang1-60) * DEG2RAD);
      
      double ang2 = getParam(paramValues,2);
      double c = Math.cos((ang1-60+ang2)*DEG2RAD);
      double s = Math.sin((ang1-60+ang2)*DEG2RAD);
      double px = ln * s60/c60;
      
      int r = 0;
      while( ang2>0 && (c<0 || x5+(ln+y5)*s/c > px)){
         r++;
         double c2 = -c * c60 + s * s60;         
         double s2 = -c * s60 - s * c60;
         c = c2;
         s = s2;
         double x5t = -x5 * c60 + y5 * s60;         
         double y5t = -x5 * s60 - y5 * c60;
         x5 = x5t;
         y5 = y5t;         
      }
      while( ang2<0 && (c<0 || x5+(ln+y5)*s/c < -px)){
         r--;
         double c2 = -c * c60 - s * s60;         
         double s2 =  c * s60 - s * c60;
         c = c2;
         s = s2;
         double x5t = -x5 * c60 - y5 * s60;         
         double y5t = +x5 * s60 - y5 * c60;
         x5 = x5t;
         y5 = y5t;
      }
      double x4 = x5 + (ln+y5)*s/c;
      double y4 = -ln;
      double x3 = -px;
      double y3 = -ln;
      while( r<0 ){
         r++;
         double x5t = -x5 * c60 + y5 * s60;         
         double y5t = -x5 * s60 - y5 * c60;
         x5 = x5t;
         y5 = y5t;
         double x4t = -x4 * c60 + y4 * s60;         
         double y4t = -x4 * s60 - y4 * c60;
         x4 = x4t;
         y4 = y4t;
         double x3t = -x3 * c60 + y3 * s60;         
         double y3t = -x3 * s60 - y3 * c60;
         x3 = x3t;
         y3 = y3t;
      }
      while( r>0){
         r--;
         double x5t = -x5 * c60 - y5 * s60;         
         double y5t =  x5 * s60 - y5 * c60;
         x5 = x5t;
         y5 = y5t;
         double x4t = -x4 * c60 - y4 * s60;         
         double y4t =  x4 * s60 - y4 * c60;
         x4 = x4t;
         y4 = y4t;
         double x3t = -x3 * c60 - y3 * s60;         
         double y3t =  x3 * s60 - y3 * c60;
         x3 = x3t;
         y3 = y3t;
      }
      double x1 = -x5 * c60 + y5 * s60;
      double y1 = -x5 * s60 - y5 * c60;
      double x2 = -x4 * c60 + y4 * s60;
      double y2 = -x4 * s60 - y4 * c60;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[0].getX(3);
      offsets[1] = tiles[1].getY(3)-tiles[0].getY(3);
      offsets[2] = tiles[2].getX(3)-tiles[0].getX(3);
      offsets[3] = tiles[2].getY(3)-tiles[0].getY(3);
   }
}