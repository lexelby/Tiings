package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_20
   extends TilingType
{
   public TilingTypeNC6_20(){
      super( "NC6-20", 6, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{210};
      paramDef = new int[]{130};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,0, 0,0,5, 0},
            {1, 4,3, 0,4,5, 0},
            {1, 5,0, 2,0,5, 0},
      };
      info = "b=c=d=e=f\nB=D\nB+C=360\nD+2E=360\n(A+F=E)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .4;
      double a = getParam(paramValues, 0);
      double z = 90-a/2;

      double c = ln * Math.cos( z * DEG2RAD );
      double s = ln * Math.sin( z * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  c, -s);
      baseTile.setPoint(2,2*c,  0);
      baseTile.setPoint(3,3*c, -s);
      baseTile.setPoint(4,4*c,  0);
      baseTile.setPoint(5,4*c, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(0);
   }
}