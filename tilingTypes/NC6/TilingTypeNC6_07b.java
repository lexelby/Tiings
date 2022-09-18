package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_07b
   extends TilingType
{
   public TilingTypeNC6_07b(){
      super( "NC6-7b", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 90, 50};
      paramName = new String[]{"Angle", "Offset"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {0, 0,5, 1,0,5, 0},
            {1, 2,3, 2,1,2, 1},
      };
      info = "c=d=e=f\nB+C=180\nC+D=360\nC=E\nE+2F=360\n(A+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .3;
      double a = getParam(paramValues, 0);
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );

      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1,4*ln,    0);
      baseTile.setPoint(2,4*ln+c,  s);
      baseTile.setPoint(3,3*ln+c,  s);
      baseTile.setPoint(4,3*ln+2*c, 2*s);
      baseTile.setPoint(5,2*ln+2*c, 2*s);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = getParam(paramValues, 1)/50 - 1;

      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
      if( os>=0 ){
         offsets[0] += os * offsets[2];
         offsets[1] += os * offsets[3];
      } else {
         offsets[2] += os * offsets[0];
         offsets[3] += os * offsets[1];
      }
   }
}