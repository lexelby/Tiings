package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_102a
   extends TilingType
{
   public TilingTypeNC6_102a(){
      super( "NC6-102a", 6, SymmetryType.p2);

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{ 100};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
         {0, 0,0, 0,0,0, 0},
         {1, 1,0, 0,0,1, 0},
         {2, 1,2, 0,3,4, 1},
         {0, 5,0, 0,0,5, 0},
         {1, 1,0, 3,0,1, 0},
         {2, 1,2, 3,3,4, 1},
      };
      info = "a=d=f\nb=c=e\nA+B+C=360\nB=F\nC+E=360\n(D+E+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 0.6;
      double b = getParam(paramValues,0);
      
      double t = - Math.tan( b/2 * DEG2RAD ) - 1 / Math.sin( b * DEG2RAD );
      double c = Math.atan(1/t)/DEG2RAD;
      double z = c-90-b/2;
      double lnc = lna*Math.sin((180-c-z)*DEG2RAD)/Math.sin(z*DEG2RAD);
      
      double x1 = lna;
      double y1 = 0;
      double x2 = x1 + lna * Math.cos( (180-b) * DEG2RAD );
      double y2 = y1 + lna * Math.sin( (180-b) * DEG2RAD );
      double x3 = x2 + lnc * Math.cos( (-b-c) * DEG2RAD );
      double y3 = y2 + lnc * Math.sin( (-b-c) * DEG2RAD );
      double x5 = 0  + x3-x2;
      double y5 = 0  + y3-y2;
      double x4 = x5 + lnc * Math.cos( (180-c) * DEG2RAD );
      double y4 = y5 + lnc * Math.sin( (180-c) * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(5)-tiles[2].getX(0);
      offsets[1] = tiles[1].getY(5)-tiles[2].getY(0);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(2);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(2);
   }
}