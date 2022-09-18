package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_11
   extends TilingType
{
   public TilingTypeNC6_11(){
      super( "NC6-11", 6, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 90};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 4,5, 0,3,2, 0},
            {1, 1,2, 1,1,0, 0},
            {0, 4,5, 2,3,2, 0},
      };
      info = "b=c=d=f\na=e\n2B+C=360\nE+F=360\nA+C+F=360\n(B+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double a = getParam(paramValues, 0)/2;
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );
      double b = 540-a*2;
      double c2 = ln * Math.cos( b * DEG2RAD );
      double s2 = ln * Math.sin( b * DEG2RAD );

      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1,  ln,    0);
      baseTile.setPoint(2,ln+c,    s);
      baseTile.setPoint(3,  ln,  s+s);
      baseTile.setPoint(4,(ln+c2)/2, s+s2/2);
      baseTile.setPoint(5,(ln-c2)/2, s-s2/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(3)-tiles[0].getY(0);
   }
}